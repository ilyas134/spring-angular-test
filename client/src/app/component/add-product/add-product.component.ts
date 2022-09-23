import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/_model/Product';
import { NgForm } from '@angular/forms'
import { ProductsApiService } from 'src/app/service/products-api.service';
import { HttpErrorResponse } from '@angular/common/http';
import { HandleFile } from 'src/app/_model/HandleFile';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  product: Product = {

    articleName: "",
    price: 0,
    images:[]
  }
  constructor(private productService: ProductsApiService,private sanitizer:DomSanitizer) { }

  ngOnInit(): void {
  }
  addProduct(productForm: NgForm) {
    const productFormData=this.createFormData(this.product)
    this.productService.addProduct(productFormData).subscribe((response: Product) => {
      console.log(response)
    }, (error: HttpErrorResponse) => {
      console.log(error)
    }
    )
  }
  createFormData(product:Product):FormData{
    const formData=new FormData();
    formData.append(
      'article',
      new Blob([JSON.stringify(product)],{type:'application/json'})
    )
    for(var i=0;i<product.images.length;i++){
      formData.append(
        "imageFile",
        product.images[i].file,
        product.images[i].file.name
      );
    }

    return formData;
  }
  onFileSelect(event:any){
     if(event.target.files){
      const file = event.target.files[0];
      const handleFile:HandleFile={
          file:file,
          url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file))
      }
      this.product.images.push(handleFile)
     }
  }
  removeImage(i:number){
    this.product.images.splice(i,1);
  }
}
