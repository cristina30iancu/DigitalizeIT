import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NjserviceService {
  PATH_OF_API = 'http://localhost:8085';

  requestHeader = new HttpHeaders({ 'Content-Type': 'application/json' })

  constructor( private httpclient: HttpClient) { }

  public getPositions(){
    return this.httpclient.get(this.PATH_OF_API+ '/position', {
      headers: this.requestHeader
    });
  }
  public getEquipments(position){
    return this.httpclient.get(this.PATH_OF_API+ '/equipment/'+position, {
      headers: this.requestHeader
    });
  }
  public getNewJoiners(done){
    return this.httpclient.get(this.PATH_OF_API+ '/newJoiner/done/'+done, {
      headers: this.requestHeader
    });
  }
  public getNewJoinerById(id){
    return this.httpclient.get(this.PATH_OF_API+ '/newJoiner/'+id, {
      headers: this.requestHeader
    });
  }
  public addNewJoiner(newJoiner){
    return this.httpclient.post(this.PATH_OF_API+'/newJoiner', newJoiner, {
      headers: this.requestHeader
    })
  }
  public assignEquipment(newJoinerId, eqList: any[]){
    return this.httpclient.put(this.PATH_OF_API+'/equipmentNewJoiner/'+newJoinerId, eqList, {
      headers: this.requestHeader
    })
  }
  public getAssignedEquipments(newJoinerId){
    return this.httpclient.get(this.PATH_OF_API+'/equipmentNewJoiner/equipmentsOfNewjoiner/'+newJoinerId, {
      headers: this.requestHeader
    })
  }
  public getAssignedEquipmentsDone(newJoinerId){
    return this.httpclient.get(this.PATH_OF_API+'/equipmentNewJoiner/'+newJoinerId, {
      headers: this.requestHeader
    })
  }
  public getDoneEquipments(newJoinerId){
    return this.httpclient.get(this.PATH_OF_API+'/equipmentNewJoiner/equipmentsOfNewjoiner/'+newJoinerId+'/done', {
      headers: this.requestHeader
    })
  }
  public updateEquipments(newJoinerId,eqId){
    return this.httpclient.put(this.PATH_OF_API+'/equipmentNewJoiner/'+newJoinerId +'/'+eqId, {
      headers: this.requestHeader
    })
  }
} 