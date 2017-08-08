import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class AuthenticationService {
    constructor(
        private http: Http,
        private router: Router
    ) { }

    login(username: string, password: string) {
        let credentials = new FormData(document.querySelector("form"));

        //If authorized, set a session.
        return this.http.post('/api/account/authorize', credentials).map(response=>{
            localStorage.setItem('currentUser', 'admin');
            return response.json();
        });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.router.navigate(['']);
    }
}