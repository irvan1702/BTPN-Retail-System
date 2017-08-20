import { Injectable } from '@angular/core';
import { Http, URLSearchParams, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class UserService {
    constructor(private http: Http) { }

    getUsers() {
        return this.http.get('http://localhost:8080/userList').map(response => {
            return response.json();
        });
    }

    getUser(id) {
        // let params = new URLSearchParams();
        // params.append('itemId?=', 1';
        return this.http.get('http://localhost:8080/userById/' + id).map(response => {
            return response.json();
        });
    }

    getUserByUsername(username) {
        // let params = new URLSearchParams();
        // params.append('itemId?=', 1';
        return this.http.get('http://localhost:8080/userByUsername?username=' + username).map(response => {
            return response.json();
        });
    }

    addUser(user) {
        return this.http.post('http://localhost:8080/userAdd', user).map((response) => {
            return response;
        });
    }
    modifyUser(user) {
        return this.http.put('http://localhost:8080/userModify', user).map((response) => {
            return response;
        });
    }

    deleteUser(id) {
        return this.http.delete('http://localhost:8080/userDelete?userId='+id).map((response) => {
            return response;
        });
    }

}