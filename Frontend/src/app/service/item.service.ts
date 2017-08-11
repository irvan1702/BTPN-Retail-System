import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

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

    getItem(id)
    {
        let params: URLSearchParams = new URLSearchParams();
        params.set('itemById', id);
        return this.http.get('http://localhost:8080/itemById',{search:params}).map(response => {
            return response.json();
        });
    }

    addItem()
    {
        let item; 
        return this.http.post('http://localhost:8080/itemAdd',item).map(response => {
            return response.json();
        });
    }
    modifyGood(itemData)
    {
        return this.http.post('/api/item/modify', itemData).map(response => {
            return response.json();
        });
    }

    deleteGood(id: number)
    {
        return this.http.delete(`/api/item/${id}`).map(response => {
            return response.json();
        });
    }

    getCategories()
    {
        return this.http.get('api/category/all').map(response => {
            return response.json();
        });
    }
}