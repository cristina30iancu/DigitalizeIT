import { Component, OnInit } from '@angular/core';
import { NjserviceService } from '../_services/njservice.service';

@Component({
  selector: 'app-list-nj',
  templateUrl: './list-nj.component.html',
  styleUrls: ['./list-nj.component.css']
})
export class ListNjComponent implements OnInit {
  newJoiners: any;
  constructor(private njService: NjserviceService) { this.newJoiners = [];}

  ngOnInit() {
    this.njService.getNewJoiners().subscribe(res => { this.newJoiners = res;})
  }

}
