import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './components/inicio/inicio.component';
import { ListRegistroComponent } from './components/list-registro/list-registro.component';
import { FormularioRegistroComponent } from './components/formulario-registro/formulario-registro.component';
import { EnunciadoComponent } from './components/enunciado/enunciado.component';
const routes: Routes = [
  {path: 'inicio',component: InicioComponent},
  {path: 'list',component: ListRegistroComponent},
  {path: 'enunciado',component: EnunciadoComponent},
  {path: 'formReg',component: FormularioRegistroComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
