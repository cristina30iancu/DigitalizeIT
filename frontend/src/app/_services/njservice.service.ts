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
  public getNewJoiners(){
    return this.httpclient.get(this.PATH_OF_API+ '/newJoiner', {
      headers: this.requestHeader
    });
  }
  public addNewJoiner(newJoiner){
    return this.httpclient.post(this.PATH_OF_API+'/newJoiner', newJoiner, {
      headers: this.requestHeader
    })
  }
}
