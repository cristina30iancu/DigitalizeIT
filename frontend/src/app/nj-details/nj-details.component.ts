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
  todo = [];

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
          console.log(res)
          for(let eq of this.equipments) {
            let stringy = 'Name: ' + eq.name + ', specifications: ' +eq.specifications;
            this.todo.push(stringy);
          }
          console.log(this.todo, res, this.equipments);         
        });
      })
       } else console.error("id is zero, cannot send request");      
  }
  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
    }
  }
 
}
