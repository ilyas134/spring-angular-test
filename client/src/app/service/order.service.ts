import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from '../_model/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  readonly API_URL="http://localhost:8080"
  readonly ENDPOINT_ORDER="/api/Order/"
  constructor(private http : HttpClient) { }
  getOrders(){
    return this.http.get<Order[]>(this.API_URL+this.ENDPOINT_ORDER)
  }
}
