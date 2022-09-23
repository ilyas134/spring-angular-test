import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/service/cart.service';
import { ProductsApiService } from 'src/app/service/products-api.service';
import { Order } from 'src/app/_model/Order';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent implements OnInit {
  public products : any = [];
  public productsID :number[]=[]
  public grandTotal !: number;
  constructor(private cartService : CartService,private api :ProductsApiService) { }

  ngOnInit(): void {
    this.cartService.getProducts()
    .subscribe(res=>{
      this.products = res;
      console.log(this.products)
      this.grandTotal = this.cartService.getTotalPrice();
    })
  }
  removeItem(item: any){
    this.cartService.removeCartItem(item);
  }
  emptycart(){
    this.cartService.removeAllCart();
  }
  makeOrder(){
    for(let i=0;i<this.products.length;i++){
      this.productsID.push(this.products[i].articleId)

    }
    const orderToCreate:Order={
      articlesId:this.productsID
    }
    this.api.addOrder(orderToCreate).subscribe(
     (res)=> {
      console.log(res)
      this.emptycart()}
    )
  }

}
