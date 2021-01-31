import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from '../../list-registro/service/register';

@Injectable({
  providedIn: 'root'
})
export class RegisterServiceService {

  constructor(private http: HttpClient) { }

crearRegistro(registro: Register): Observable<any>{
  return this.http.post<Register>('http://localhost:8080/register/add',registro)

}



}
