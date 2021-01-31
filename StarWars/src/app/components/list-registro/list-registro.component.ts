import { Component, OnInit } from '@angular/core';
import { Register } from './service/register';
import { RestService } from './service/rest.service';

@Component({
  selector: 'app-list-registro',
  templateUrl: './list-registro.component.html',
  styleUrls: ['./list-registro.component.scss'],
  providers: [RestService]

})
export class ListRegistroComponent implements OnInit {

  constructor(private rs : RestService) { }


  colums = ["Nombre","Planeta","Fecha"];



   register : Register[];

  ngOnInit(): void {
    this.getRegisters();
  }

  async getRegisters(){
    this.register=await this.rs.getRegister();
    console.log(this.register);
  }

}
