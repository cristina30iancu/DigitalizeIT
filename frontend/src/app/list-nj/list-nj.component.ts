import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NjserviceService } from '../_services/njservice.service';

@Component({
  selector: 'app-list-nj',
  templateUrl: './list-nj.component.html',
  styleUrls: ['./list-nj.component.css']
})
export class ListNjComponent implements OnInit {
  newJoiners: any;
  constructor(private njService: NjserviceService,private router: Router) { this.newJoiners = [];}

  ngOnInit() {
    this.njService.getNewJoiners('false').subscribe(res => { this.newJoiners = res; console.log(res)})
  }
  viewNJ(event: any, njId: number): void {
    event.stopPropagation();
   this.router.navigate(['newJoiner', njId,'it-support']);
  }
}
