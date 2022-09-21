import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn: boolean;
  constructor() {this.isLoggedIn= true; }

  ngOnInit(): void {
    this.isLoggedIn= true;
  }

}
