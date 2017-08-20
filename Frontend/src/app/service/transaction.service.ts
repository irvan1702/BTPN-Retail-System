import { Injectable } from '@angular/core';
import { Transaction } from '../model/Transaction';
import { Http, URLSearchParams, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class TransactionService {
    constructor(private http: Http) { }

    getTransactions() {
        return this.http.get('http://localhost:8080/transactionList').map(response => {
            return response.json();
        });
    }

    getTransaction(id) {
        // let params = new URLSearchParams();
        // params.append('itemId?=', 1';
        return this.http.get('http://localhost:8080/transactionById?transactionId=' + id).map(response => {
            return response.json();
        });
    }

    addTransaction(transaction :Transaction) {
        console.log(transaction);
        return this.http.post('http://localhost:8080/transactionAdd', transaction).map((response) => {
            return response;
        });
    }
    modifyTransaction(transaction) {
        return this.http.put('http://localhost:8080/transactionModify', transaction).map((response) => {
            return response;
        });
    }

    deleteTransaction(id) {
        return this.http.delete('http://localhost:8080/transactionDelete?transactionId='+id).map((response) => {
            return response;
        });
    }

    calculatePrice(userId, itemId, quantity){
        return this.http.get('http://localhost:8080/calculateNet/'+userId+'/'+itemId+'/'+quantity).
        map(response =>{
            return response.json();
        })
    }

}