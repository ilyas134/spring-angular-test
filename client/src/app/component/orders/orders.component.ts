import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import { Order } from 'src/app/_model/Order';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  displayedColumns: string[] = ['Id', 'UUID', 'Created date'];
  orderDetails : Order[]=[];
  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
    this.getProducts();
  }
 getProducts(){
  this.orderService.getOrders().subscribe(
    (res:Order[])=>{
     this.orderDetails=res; 
    },(error:HttpErrorResponse)=>{
      console.log(error)
    }
  )
 }
}
