import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NjserviceService } from '../_services/njservice.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  newJoiners: any;
  constructor(private njService: NjserviceService,private router: Router) { this.newJoiners = [];}

  ngOnInit() {
    this.newJoiners = []
    this.njService.getNewJoiners('true').subscribe(res => { this.newJoiners = res;})
  }
  viewNJ(event: any, njId: number): void {
    event.stopPropagation();
   this.router.navigate(['history','newJoiner', njId]);
  }
}
