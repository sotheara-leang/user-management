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
				url: Url.API.DEPARTMENT.SEARCH,
				datatype: 'json',
				colNames: [I18n['general.id'], I18n['department.name']],
				colModel:[
		     		{name: 'id', index: 'dept_id', width: 100, formatter: this.idCellFmatter},
		     		{name: 'name', index: 'dept_name', width: 150},
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
				pager: '#departmentGridPager',
				sortname: 'dept_name',
			    sortorder: 'asc',
				beforeRequest: function() {
					var postData = $('#departmentGrid').jqGrid('getGridParam', 'postData');
					delete postData.name;
					if ($('#searchName').val() !== '') {
						postData.name = $('#searchName').val();
					}
				},
				onSelectRow: function(rowId, status, event) {
					if (rowId) {
						$('#btnDeleteDepartment').prop('disabled', false);
					}
				}
			};
			$('#departmentGrid').jqGrid(gridOptions);
			this.initGridWidth();
		},
		bindView: function() {
			$('#btnNewDepartment').click(function() {
				page.openDepartmentModel();
			});
			$('#btnDeleteDepartment').click(function() {
				page.deleteDepartment();
			});
			$('#btnSearch').click(function() {
				page.searchDepartments();
			});
			$('#btnReset').click(function() {
				page.resetSearchForm();
			});
			$('#btnSaveDepartment').click(function() {
				page.saveDepartment();
			});
		
			$(document).on('click', 'a.linkEditDepartment', function() {
				page.openDepartmentModel($(this).attr('value'));
			});
			
			$(window).on('resize', function () {
				page.initGridWidth();
			});
		},
		searchDepartments: function() {
			 $('#departmentGrid').trigger('reloadGrid'); 
		},
		resetSearchForm: function() {
			$('#searchName').val('');
		},
		openDepartmentModel: function(departmentId) {
			$('#departmentModelTitle').text(departmentId ? I18n['department.modify'] : I18n['department.btn.new']);
			if (departmentId) {
				var url = Url.API.DEPARTMENT.BASE + '/' + departmentId;
				$.get(url, function(department) {
					$('#id').val(department.id);
					$('#name').val(department.name);
				});
			} else {
				$('#id').val('');
				$('#name').val('');
			}
			$('#departmentModel').modal('show');
		},
		saveDepartment: function() {
			var department = {};
			department.id = $('#id').val() ? parseInt($('#id').val()) : null;
			department.name = $('#name').val();
			
			var url = Url.API.DEPARTMENT.BASE + (department.id !== null ? '/' + department.id : '');
			var method = department.id !== null ? 'put' : 'post';
			
			$.ajax({
				url: url,
		        type: method,
		        contentType: 'application/json',
		        data: JSON.stringify(department),
		        success: function () {
		        	$('#departmentModel').modal('hide');
		        	$('#departmentGrid').trigger('reloadGrid');
		        }
		    });
		},
		deleteDepartment: function() {
			var departmentId = $('#departmentGrid').jqGrid ('getGridParam', 'selrow');
			if (departmentId) {
				var url = Url.API.DEPARTMENT.BASE + '/' + departmentId;
				$.ajax({
					url: url,
			        type: 'delete',
			        success: function () {
			        	$('#btnDeleteDepartment').prop('disabled', true);
			        	$('#departmentGrid').trigger('reloadGrid');
			        }
			    });
			}
		},
		initGridWidth: function() {
			var grid = $('#departmentGrid'),
		    newWidth = grid.closest('.ui-jqgrid').parent().width();
		    grid.jqGrid('setGridWidth', newWidth, true);
		},
		idCellFmatter: function(cellvalue, options, department) {
			var html = '<a href="#" class="linkEditDepartment" value="' + department.id + '">' + department.id + '</a>';
		    return html;
		}
	};

})(window, document, window.jQuery);