(function(window, document, $) {
	'use strict';
	
	$(document).ready(function () {
		page.init();
	});
	
	var page = {
		init: function() {
			this.initView();
			this.bindView();
		},
		initView: function () {
			var gridOptions = {
				url: Url.API.USER.SEARCH,
				datatype: 'json',
				colNames: [I18n['general.id'], I18n['general.username'], I18n['general.role'], I18n['general.email']],
				colModel:[
		     		{name: 'id', index: 'user_id', width: 100, formatter: this.idCellFmatter},
		     		{name: 'username', index: 'user_username', width: 150},
		     		{name: 'role', index: 'user_role', width: 100},
		     		{name: 'email', index: 'user_email', width: 150}
				],
				jsonReader: { 
					root: 'records',
					page: 'page',
					total: 'totalPages',
					records: 'totalRecords',
					id: 'id'
				},
				prmNames: {
					rows: 'size',
					sort: 'sort',
					order: 'direction',
					search: null,
					nd: null
				},
				caption: '',
				viewrecords: true,
				multiselect: false,
				rowNum: 10,
				rowList: [10, 20, 30],
				pager: '#userGridPager',
				sortname: 'user_username',
			    sortorder: 'asc',
				beforeRequest: function() {
					var postData = $('#userGrid').jqGrid('getGridParam', 'postData');
					delete postData.username;
					delete postData.role;
					delete postData.email;
					if ($('#searchUsername').val() !== '') {
						postData.username = $('#searchUsername').val();
					}
					if ($('#searchRole').val() !== '') {
						postData.role = $('#searchRole').val();
					}
					if ($('#searchEmail').val() !== '') {
						postData.email = $('#searchEmail').val();
					}
				},
				onSelectRow: function(rowId, status, event) {
					if (rowId) {
						$('#btnDeleteUser').prop('disabled', false);
					}
				}
			};
			$('#userGrid').jqGrid(gridOptions);
			this.initGridWidth();
		},
		bindView: function() {
			$('#btnNewUser').click(function() {
				page.openUserModel();
			});
			$('#btnDeleteUser').click(function() {
				page.deleteUser();
			});
			$('#btnSearch').click(function() {
				page.searchUsers();
			});
			$('#btnReset').click(function() {
				page.resetSearchForm();
			});
			$('#btnSaveUser').click(function() {
				page.saveUser();
			});
			$('ul#btnExportUsers a').click(function() {
				var userGrid = $('#userGrid');
				
				var param = {};
				param.format = $(this).data('format');
				param.size = userGrid.getGridParam('rowNum');
				param.page = userGrid.getGridParam('page');
				param.sort = userGrid.getGridParam('sortname');
				param.direction = userGrid.getGridParam('sortorder');
				
				if ($('#searchUsername').val() !== '') {
					param.username = $('#searchUsername').val();
				}
				if ($('#searchRole').val() !== '') {
					param.role = $('#searchRole').val();
				}
				if ($('#searchEmail').val() !== '') {
					param.email = $('#searchEmail').val();
				}
				
				var url = Url.USER.REPORT + '?' + $.param(param);
				
				window.open(url, '_blank');
				
			});
			
			$(document).on('click', 'a.linkEditUser', function() {
				page.openUserModel($(this).attr('value'));
			});
			
			$(window).on('resize', function () {
				page.initGridWidth();
			});
		},
		searchUsers: function() {
			 $('#userGrid').trigger('reloadGrid'); 
		},
		resetSearchForm: function() {
			$('#searchUsername').val('');
			$('#searchRole').val('');
			$('#searchEmail').val('');
		},
		openUserModel: function(userId) {
			$('#userModelTitle').text(userId ? I18n['user.modify'] : I18n['user.btn.new']);
			$.get(Url.API.DEPARTMENT.BASE, function(departments) {
				var departmentField = $('#department');
				departmentField.find('option').remove();
				departmentField.append($('<option>').attr('value', '').text(''));
				$(departments).each(function() {
					departmentField.append($('<option>').attr('value', this.id).text(this.name));
				});
				
				if (userId) {
					var url = Url.API.USER.FIND_USER_WITH_DEPARTMENT + '/' + userId;
					$.get(url, function(user) {
						$('#id').val(user.id);
						$('#username').val(user.username);
						$('#role').val(user.role);
						$('#email').val(user.email);
						$('#allowLoginEmailNotification').prop('checked', user.allowLoginEmailNotification);
						if (user.department && user.department.id) {
							$('#department').val(user.department.id);
						}
					});
				} else {
					$('#id').val('');
					$('#username').val('');
					$('#role').val('');
					$('#email').val('');
					$('#allowLoginEmailNotification').prop('checked', false);
					$('#department').val('');
				}
				
				$('#password').val('');
				$('#userModel').modal('show');
			});
		},
		saveUser: function() {
			var user = {};
			user.id = $('#id').val() ? parseInt($('#id').val()) : null;
			user.username = $('#username').val();
			user.role = $('#role').val();
			user.email = $('#email').val();
			user.allowLoginEmailNotification = $('#allowLoginEmailNotification').prop('checked');
			if ($('#password').val() !== '') {
				user.password = $('#password').val();
			}
			if ($('#department').val() !== '') {
				user.department = {};
				user.department.id = $('#department').val();
			}
			
			var url = Url.API.USER.BASE + (user.id !== null ? '/' + user.id : '');
			var method = user.id !== null ? 'put' : 'post';
			
			$.ajax({
		        url: url,
		        type: method,
		        contentType: 'application/json',
		        data: JSON.stringify(user),
		        success: function () {
		        	$('#userModel').modal('hide');
		        	$('#userGrid').trigger('reloadGrid');
		        }
		    });
		},
		deleteUser: function() {
			var userId = $('#userGrid').jqGrid ('getGridParam', 'selrow');
			if (userId) {
				var url = Url.API.USER.BASE + '/' + userId;
				$.ajax({
			        url: url,
			        type: 'delete',
			        success: function () {
			        	$('#btnDeleteUser').prop('disabled', true);
			        	$('#userGrid').trigger('reloadGrid');
			        }
			    });
			}
		},
		initGridWidth: function() {
			var grid = $('#userGrid'),
		    newWidth = grid.closest('.ui-jqgrid').parent().width();
		    grid.jqGrid('setGridWidth', newWidth, true);
		},
		idCellFmatter: function(cellvalue, options, user) {
			var html = '<a href="#" class="linkEditUser" value="' + user.id + '">' + user.id + '</a>';
		    return html;
		}
	};

})(window, document, window.jQuery);