import { Component, OnInit } from '@angular/core';
import { NjserviceService } from '../_services/njservice.service';

@Component({
  selector: 'app-view-history',
  templateUrl: './view-history.component.html',
  styleUrls: ['./view-history.component.css']
})
export class ViewHistoryComponent implements OnInit {
  newJoiner: any;
  equipments: any;
  done :any;
  eqListIds = [];
  constructor(private njService: NjserviceService) { }

  async ngOnInit() {
    const path = window.location.href.split('/');
    const id = parseInt(path[path.length-1]);
    await this.njService.getAssignedEquipmentsDone(id).subscribe(res => {this.equipments = res; console.log(res)})  
    if(id > 0) {
     await this.njService.getNewJoinerById(id).subscribe(res => { 
        this.newJoiner = res;
      })
       } else console.error("id is zero, cannot send request");     
  }


}
