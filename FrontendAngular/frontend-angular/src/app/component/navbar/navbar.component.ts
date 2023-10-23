import { Component, OnInit } from '@angular/core';
import { NavbarService } from '../../service/navbar.service';
import { Category } from '../../class/category-navbar';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  categoryList: Category[];

  constructor(private categoryService: NavbarService) { }

  ngOnInit(): void {
    this.getCategoryList();
  }

  private getCategoryList() {
    this.categoryService.getCategoryList().subscribe(data => {
      this.categoryList = data;
    })
  }

}
