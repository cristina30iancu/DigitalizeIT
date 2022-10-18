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
  submitted: Boolean;
  eqListIds = [];
  constructor(private njService: NjserviceService) { }

  async ngOnInit() {
    const path = window.location.href.split('/');
    const id = parseInt(path[path.length - 2]);
    await this.njService.getAssignedEquipments(id).subscribe(res => { this.equipments = res; })
    if (id > 0) {
      await this.njService.getNewJoinerById(id).subscribe(res => {
        this.newJoiner = res;
        this.njService.getDoneEquipments(id)
          .subscribe((response) => {
            this.done = response;
          });
      });
    } else console.error("id is zero, cannot send request");
  }
  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      this.submitted = false;
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
      console.log('if')
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
      this.equipments = [...newList] }
      this.submitted = false;
    }
  submit() {
    for (let d of this.done) {
      this.njService.updateEquipments(this.newJoiner.id, d.id).subscribe(res => this.submitted = true);
    }
  }
}

