import { Component, OnInit, ElementRef, ViewChild, HostListener } from '@angular/core';
import { Newspaper } from '../../class/newspaper';
import { NewspaperService } from '../../service/newspaper.service';

@Component({
  selector: 'app-newspaper',
  templateUrl: './newspaper.component.html',
  styleUrls: ['./newspaper.component.css']
})
export class NewspaperComponent implements OnInit {

  newspaperList: Newspaper[] = [];
  newspaperList1: Newspaper[] = [];
  public totalCount = 0;
  public pageCurrent = 0;
  //public pageIndex = 1;
  public oldPageIndex = this.pageCurrent - 1;
  public pageSize = 6;


  //@ViewChild('uiElement', { static: false }) public uiElement: ElementRef;

  constructor(private newspaperService: NewspaperService) { }

  public ngOnInit(): void {
    this.getNewspapers();
  };

  private getNewspapers() {
    this.newspaperService.getNewspaper().subscribe(data => {
      this.newspaperList = data;
      this.newspaperList.reverse();

      this.totalCount = this.newspaperList.length;
      let startIndex = this.pageCurrent * this.pageSize;
      let endIndex = startIndex + this.pageSize;

      if (this.totalCount > endIndex) {
        for (let i = startIndex; i < endIndex; i++) {
          this.newspaperList1.push(this.newspaperList[i]);
        }
      } else if ((endIndex - this.totalCount) < 6) {
        for (let i = startIndex; i < this.totalCount; i++) {
          this.newspaperList1.push(this.newspaperList[i]);
        }
      }
      else { this.oldPageIndex = 0; }
    });

    this.oldPageIndex = this.pageCurrent - 1;
  }

  @HostListener("window:scroll", ["$event"])
  public OnScroll() {
    let pos = (document.documentElement.scrollTop || document.body.scrollTop) + document.documentElement.clientHeight;
    let max = document.documentElement.scrollHeight - 1;
    if (pos > max) {
      if ((this.pageCurrent - this.oldPageIndex) == 1) {
        this.pageCurrent++;
        setTimeout(() => this.getNewspapers(), 1000);
      }
    }
  }

  crawlNewspapers() {
    this.newspaperService.crawlNewspapers().subscribe(data => {
      this.getNewspapers();
    })
  }
}
