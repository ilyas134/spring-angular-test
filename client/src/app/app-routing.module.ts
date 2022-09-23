import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from './component/products/products.component'
import {OrdersComponent} from './component/orders/orders.component'
import {AddProductComponent} from './component/add-product/add-product.component'
import {CardComponent} from './component/card/card.component'

const routes: Routes = [
  {path:'',component:ProductsComponent},
  {path:'orders',component:OrdersComponent},
  {path:'add-product',component:AddProductComponent},
  {path:'cart',component:CardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
