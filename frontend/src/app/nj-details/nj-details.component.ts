import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { NjserviceService } from '../_services/njservice.service';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-nj-details',
  templateUrl: './nj-details.component.html',
  styleUrls: ['./nj-details.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class NjDetailsComponent implements OnInit {
  newJoiner: any;
  equipments: any;
  done = [];

  constructor(private njService: NjserviceService) { }

  async ngOnInit() {
    const path = window.location.href.split('/');
    const id = parseInt(path[path.length-1]);
    if(id > 0) {
     await this.njService.getNewJoinerById(id).subscribe(res => { 
        this.newJoiner = res;
        this.njService.getEquipments(this.newJoiner.position)
        .subscribe((res) => {
        this.equipments = res;         
        });
      })
       } else console.error("id is zero, cannot send request");      
  }
  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
     
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
      
      let newList = this.equipments
      this.equipments = [...newList] 
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
      let newList = this.equipments
      this.equipments = [...newList] 
    }
  }
 
}
