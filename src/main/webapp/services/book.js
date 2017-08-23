'use strict';

app
    .service('bookService', function ($http) {
        return {
            list: function (text, success) {
            	var url = "/rest/book";
            	if (text!=null){
            		url += "?text="+text;
            	}
            	return $http.get(url).then(success);
            },
            save: function (book, success) {
                return $http.post("/rest/book", book).then(success);
            },
            get: function (id, success) {
                return $http.get("/rest/book/" + id).then(success);
            },
            remove: function (id, success) {
                return $http.delete("/rest/book/" + id).then(success);
            }
        };
    });
