import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class GoodService {
    constructor(private http: Http) { }

    getGoods() {
        return this.http.get('localhost:8080/itemList').map(response => {
            return response.json();
        });
    }

    getGood(id: number)
    {
        return this.http.get(`/api/item/${id}`).map(response => {
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