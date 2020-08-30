import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {InventoryComponent} from "./components/inventory/inventory.component";
import {ItemComponent} from "./components/item/item.component";


const routes: Routes = [
  {path:'', component: InventoryComponent},
  {path:'home', redirectTo: '', pathMatch: 'full'},
  {path:'item', component: ItemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
