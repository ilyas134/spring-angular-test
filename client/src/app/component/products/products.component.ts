import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/service/cart.service';
import { ProductsApiService } from 'src/app/service/products-api.service';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  public productList : any ;
  constructor(private api : ProductsApiService,private cartService:CartService) { }

  ngOnInit(): void {
    this.api.getProduct()
    .subscribe(res=>{
      this.productList = res;
    });
  }
  addtocart(item: any){
    console.log("adding")
    this.cartService.addtoCart(item);
  }
}
