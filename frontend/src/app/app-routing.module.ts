import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductosComponent } from './productos/productos.component';
import { VentasComponent } from './ventas/ventas.component';
import { ComprasComponent } from './compras/compras.component';
import { SujetosComponent } from './sujetos/sujetos.component';

const routes: Routes = [
  {path:'productos', component: ProductosComponent},
  {path:'', redirectTo: 'productos', pathMatch:'full'},
  {path:'venta', component: VentasComponent},
  {path:'compra', component: ComprasComponent},
  {path: 'sujetos', component: SujetosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
