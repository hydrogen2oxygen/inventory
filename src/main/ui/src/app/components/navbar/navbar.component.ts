import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  collapsed = true;
  links = [
    {title: 'New Item', link: 'item', fragment: 'item'},
  ];

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

}
