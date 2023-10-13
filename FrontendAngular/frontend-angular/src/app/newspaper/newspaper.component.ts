import { Component, OnInit } from '@angular/core';
import { Newspaper } from '../class/newspaper';
import { NewspaperService } from '../newspaper.service';

@Component({
  selector: 'app-newspaper',
  templateUrl: './newspaper.component.html',
  styleUrls: ['./newspaper.component.css']
})
export class NewspaperComponent implements OnInit {

  newspaperList: Newspaper[];

  constructor(private newspaperService: NewspaperService) { }

  ngOnInit(): void {
    this.newspaperService.getNewspaper().subscribe(data => {
      this.newspaperList = data;
    });
  }
}
