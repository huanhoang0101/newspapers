import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Newspaper } from '../../class/newspaper';
import { DetailNewspaperService } from '../../service/detail-newspaper.service';

@Component({
  selector: 'app-detail-newspaper',
  templateUrl: './detail-newspaper.component.html',
  styleUrls: ['./detail-newspaper.component.css']
})
export class DetailNewspaperComponent implements OnInit {

  id: number;
  newspaper: Newspaper;

  constructor(private detailNewspaperService: DetailNewspaperService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));

    this.detailNewspaperService.getDetailNewspaper(this.id).subscribe(data => {
      this.newspaper = data;
    })
  }
}
