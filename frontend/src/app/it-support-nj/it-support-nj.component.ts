import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { NjserviceService } from '../_services/njservice.service';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-it-support-nj',
  templateUrl: './it-support-nj.component.html',
  styleUrls: ['./it-support-nj.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ItSupportNjComponent implements OnInit {
  newJoiner: any;
  equipments: any;
  done: any;
  eqListIds = [];
  // doneList: any;
  constructor(private njService: NjserviceService) { }

  async ngOnInit() {
    this.done = [];
    const path = window.location.href.split('/');
    const id = parseInt(path[path.length - 2]);
    await this.njService.getAssignedEquipments(id).subscribe(res => { this.equipments = res; console.log(res) })
    if (id > 0) {
      await this.njService.getNewJoinerById(id).subscribe(res => {
        this.newJoiner = res;
        // this.njService.getEquipments(this.newJoiner.position)
        //   .subscribe((response) => {
        //     this.equipments = response;
        //   });
      });
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
  submit() {
    this.eqListIds = [];
    for (let d of this.done) {
      this.eqListIds.push(d.id);
    }
    this.njService.assignEquipment(this.newJoiner.id, this.eqListIds).subscribe(res => console.log(res));
  }
}

