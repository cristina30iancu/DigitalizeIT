import { Component, OnInit } from '@angular/core';
import { NjserviceService } from '../_services/njservice.service';
@Component({
  selector: 'app-nj-details',
  templateUrl: './nj-details.component.html',
  styleUrls: ['./nj-details.component.css']
})
export class NjDetailsComponent implements OnInit {
  newJoiner: any;
  equipments: any;
  constructor(private njService: NjserviceService) { }

 async ngOnInit() {
    const path = window.location.href.split('/');
    const id = parseInt(path[path.length-1]);
    if(id > 0) {
     await this.njService.getNewJoinerById(id).subscribe(res => { this.newJoiner = res;
        this.njService.getEquipments(this.newJoiner.position)
        .subscribe(res => {this.equipments = res;  console.log(res[0])})
       
      })
       } else console.error("id is zero, cannot send request");
  }

  dragItem(event) {
    event.dataTransfer.setData("Text", event.target.id);
  }
}
