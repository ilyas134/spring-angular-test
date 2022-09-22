import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import {HttpClient} from '@angular/common/http'
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Product } from '../_model/Product';
import { HandleFile } from '../_model/HandleFile';
@Injectable({
  providedIn: 'root'
})
export class ProductsApiService {
  readonly API_URL="http://localhost:8080"
  readonly ENDPOINT_ARTICLES="/api/Article/"
  
  constructor(private http : HttpClient,private sanitizer:DomSanitizer) { }
  getProduct(){
    return this.http.get<Product[]>(this.API_URL+this.ENDPOINT_ARTICLES)
    .pipe(
      map((product:Product[])=>{
      product.map((p:Product)=>{
          this.createImages(p)})
      return product;
    }))
  }

  public createImages(product:Product){
        const productImages:any[]=product.images;
        const productImagesToHandleFile:HandleFile[]=[];
        for(let i=0;i<productImages.length;i++){
          const image =productImages[i];
          const imageBlob=this.BytesToBlob(image.picture,image.type);
          const imageFile=new File([imageBlob],image.name,{type:image.type});
          const imageFileHandle:HandleFile={
            file:imageFile,
            url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
          };
          productImagesToHandleFile.push(imageFileHandle);
        }
        product.images=productImagesToHandleFile;
        return product;
  }

  public BytesToBlob(imageBytes:any,imageType:any){
   const byteString= window.atob(imageBytes);
   const arrayBuffer =new ArrayBuffer(byteString.length);
   const int8Array =new Uint8Array(arrayBuffer)
   for(let i=0;i< byteString.length;i++){
   int8Array[i]= byteString.charCodeAt(i);
   }
   const blob=new Blob([int8Array],{type:imageType})
   return blob;

  }
  public addProduct(product:FormData){
    return this.http.post<Product>(this.API_URL+this.ENDPOINT_ARTICLES,product)
  }
}
