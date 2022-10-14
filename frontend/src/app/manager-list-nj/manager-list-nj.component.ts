import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NjserviceService } from '../_services/njservice.service';

@Component({
  selector: 'app-manager-list-nj',
  templateUrl: './manager-list-nj.component.html',
  styleUrls: ['./manager-list-nj.component.css']
})
export class ManagerListNjComponent implements OnInit {
  newJoiners: any;
  constructor(private njService: NjserviceService,private router: Router) { this.newJoiners = [];}

  ngOnInit() {
    this.njService.getNewJoiners(false).subscribe(res => { this.newJoiners = res;})
  }
  viewNJ(event: any, njId: number): void {
    event.stopPropagation();
   this.router.navigate(['newJoiner', njId]);
  }
}
