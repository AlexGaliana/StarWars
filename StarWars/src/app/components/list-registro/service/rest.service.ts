import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from './register';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http : HttpClient) {

    //this.http.get('localhost:8080/register');


   }


  private url : string = "http://localhost:8080/register";

  async getRegister() : Promise<Register[]>{

    console.log( await this.http.get(this.url).toPromise());
    return this.http.get<Register[]>(this.url).toPromise();
  }




}
