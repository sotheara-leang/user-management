var Url = Url || {};

Url.USER = {};
Url.USER.BASE = 'user';
Url.USER.REPORT = Url.USER.BASE + '/report';

Url.API = {};
Url.API.BASE = 'api';

Url.API.USER = {};
Url.API.USER.BASE = Url.API.BASE + '/users';
Url.API.USER.SEARCH = Url.API.USER.BASE + '/search';
Url.API.USER.FIND_USER_WITH_DEPARTMENT = Url.API.USER.BASE + '/findUserWithDepartment';

Url.API.DEPARTMENT = {};
Url.API.DEPARTMENT.BASE = Url.API.BASE + '/departments';
Url.API.DEPARTMENT.SEARCH = Url.API.DEPARTMENT.BASE + '/search';