import { Component, OnInit } from '@angular/core';
import { Newspaper } from '../class/newspaper';
import { NewspaperService } from '../newspaper.service';

@Component({
  selector: 'app-newspaper',
  templateUrl: './newspaper.component.html',
  styleUrls: ['./newspaper.component.css']
})
export class NewspaperComponent implements OnInit {

  imgLink: string = "https://cdn.tuoitre.vn/zoom/260_163/471584752817336320/2023/10/11/z477340450860800e53db5d5652a3a5aaa33106f573a75-1697005203368409825218-100-0-1350-2000-crop-1697005272427386498601.jpg"

  /* newspaperList: Newspaper[]; */

  newspaperList: Newspaper[] = [
    {
      id: 1, title: "title1", description: "This is a longer card with supporting text below as a natural lead-in toadditionalcontent. This content is a little bit longer.",
      img: this.imgLink
    },
    {
      id: 2, title: "title2", description: "This is a longer card with supporti.",
      img: this.imgLink
    },
    {
      id: 3, title: "title3", description: "d3",
      img: this.imgLink
    },
    {
      id: 3, title: "title3", description: "d3",
      img: this.imgLink
    },
    {
      id: 3, title: "title3", description: "d3",
      img: this.imgLink
    },
    {
      id: 3, title: "title3", description: "d3",
      img: this.imgLink
    },
    {
      id: 3, title: "title3", description: "d3",
      img: this.imgLink
    }
  ]

    ;

  /* constructor(private newspaperService: NewspaperService) { }

  ngOnInit(): void {
    this.newspaperService.getNewspaper().subscribe(data => {
      this.newspaperList = data;
    });
  } */

  ngOnInit(): void {
  }

}
