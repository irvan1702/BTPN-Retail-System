import { Injectable } from '@angular/core';
import { Http, URLSearchParams, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class ItemService {
    constructor(private http: Http) { }

    getItems() {
        return this.http.get('http://localhost:8080/itemList').map(response => {
            return response.json();
        });
    }

    getItem(id) {
        // let params = new URLSearchParams();
        // params.append('itemId?=', 1';
        return this.http.get('http://localhost:8080/itemById/' + id).map(response => {
            return response.json();
        });
    }

    addItem(item) {
        //console.log(item)
        return this.http.post('http://localhost:8080/itemAdd', item).map((response) => {
            return response;
        });
    }
    modifyItem(item) {
        return this.http.put('http://localhost:8080/itemModify', item).map((response) => {
            return response;
        });
    }

    deleteItem(id) {
        return this.http.delete('http://localhost:8080/itemDelete?itemId='+id).map((response) => {
            return response;
        });
    }

}