import flet as ft

def main(page: ft.Page):

    page.theme_mode = ft.ThemeMode.LIGHT

    title = ft.Text('Sistema Integrador de calificaciones de lenguas extranjeras (SICLE)'
                ,font_family='Open-Sans',
                weight=ft.FontWeight.BOLD,size=page.width/50,
                color='white')

    barra = ft.Container(ft.Row([
        title
    ],width=page.width,
    height=page.height * 0.1,
    alignment=ft.MainAxisAlignment.CENTER)
    ,bgcolor='#0D257C',margin=-10)

    def text_sizing(e):
        title.size = page.width/50
        page.update()

    def opciones(e):
        if(e.control.selected_index == 1):
            menu.visible = False
            horario.visible = False
            personal.visible = True
            calificaciones.visible = False
            page.update()

        elif(e.control.selected_index == 0):
            menu.visible = True
            horario.visible = False
            personal.visible = False
            calificaciones.visible = False
            page.update()

        elif(e.control.selected_index == 2):
            horario.visible = True
            menu.visible = False
            personal.visible = False
            calificaciones.visible = False
            page.update()

        elif(e.control.selected_index == 3):
            calificaciones.visible = True
            menu.visible = False
            personal.visible = False
            horario.visible = False
            page.update()

        elif(e.control.selected_index == 4):
            #Enlazar con el login
            pass

    page.drawer = ft.NavigationDrawer(
        controls=[
            ft.Container(height=12),
            ft.NavigationDrawerDestination(
                label="Menu",
                icon=ft.icons.MENU
            ),
            ft.Divider(thickness=2),
            ft.NavigationDrawerDestination(
                icon_content=ft.Icon(ft.icons.PERSON),
                label="Datos Personales"
            ),
            ft.NavigationDrawerDestination(
                icon_content=ft.Icon(ft.icons.SCHEDULE),
                label="Horario"
            ),
            ft.NavigationDrawerDestination(
                icon_content=ft.Icon(ft.icons.FORMAT_LIST_NUMBERED),
                label="Calificaciones"
            ),
            ft.Divider(thickness=2),
            ft.NavigationDrawerDestination(
                icon_content=ft.Icon(ft.icons.HIGHLIGHT_OFF),
                label="Salir"
            ),
        ],on_change=opciones
    )

    def menu(e):
        page.drawer.open = True
        page.drawer.update()

    bar = ft.Container(
        ft.Column([
            ft.Container(content=ft.IconButton(ft.icons.MENU,padding=20,on_click=menu)
                         ,margin=ft.margin.only(left=-10))
        ])
    )

    menu = ft.Container(
        ft.Row([
            ft.Text('Acceso Estudiante',size=30,weight=ft.FontWeight.BOLD)
        ],alignment=ft.MainAxisAlignment.CENTER,vertical_alignment=ft.MainAxisAlignment.CENTER,
        height=page.height*0.6)
    )

    horario = ft.Container(

        ft.Column([
            ft.Row([
                ft.Container(content=ft.Text('Horario',color='white',text_align='center',size=20),bgcolor='#0D257C',
                            width=250,height=50,alignment=ft.alignment.center,border_radius=30)
            ],alignment=ft.MainAxisAlignment.CENTER),
            ft.Row([
                ft.DataTable(
                    columns=[
                        ft.DataColumn(ft.Text("Hora")),
                        ft.DataColumn(ft.Text("Lunes")),
                        ft.DataColumn(ft.Text("Martes")),
                        ft.DataColumn(ft.Text("Miercoles")),
                        ft.DataColumn(ft.Text("Jueves")),
                        ft.DataColumn(ft.Text("Viernes")),
                        ft.DataColumn(ft.Text("Sabado")),
                    ],
                    rows=[
                        ft.DataRow(
                            cells=[
                                ft.DataCell(ft.Text('----')),
                                ft.DataCell(ft.Text('----')),
                                ft.DataCell(ft.Text('----')),
                                ft.DataCell(ft.Text('----')),
                                ft.DataCell(ft.Text('----')),
                                ft.DataCell(ft.Text('----')),
                                ft.DataCell(ft.Text('----'))
                            ]
                        )
                    ]
                )
            ],alignment=ft.MainAxisAlignment.CENTER)
        ])
    )

    personal = ft.Container(
        ft.Column([
            ft.Row([
                ft.Container(content=ft.Text('Datos Personales',color='white',text_align='center',size=20),bgcolor='#0D257C',
                            width=250,height=50,alignment=ft.alignment.center,border_radius=30)
                ],alignment=ft.MainAxisAlignment.CENTER),
            ft.Row([
                ft.DataTable(
                    columns=[
                        ft.DataColumn(ft.Text('')),
                        ft.DataColumn(ft.Text(''))
                    ],
                             
                    rows=[
                        ft.DataRow(cells=[ft.DataCell(ft.Text('No. Control: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                        ft.DataRow(cells=[ft.DataCell(ft.Text('Extencion: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                        ft.DataRow(cells=[ft.DataCell(ft.Text('Plan de Estudios: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                        ft.DataRow(cells=[ft.DataCell(ft.Text('Coordinador: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                        ft.DataRow(cells=[ft.DataCell(ft.Text('Nombre: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                        ft.DataRow(cells=[ft.DataCell(ft.Text('Modalidad: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                        ft.DataRow(cells=[ft.DataCell(ft.Text('Curp: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                        ft.DataRow(cells=[ft.DataCell(ft.Text('Carrera: '))
                                                      ,ft.DataCell(ft.Text(''))]),
                    ]
                )
            ],alignment=ft.MainAxisAlignment.CENTER)
        ],alignment=ft.MainAxisAlignment.CENTER)
    )

    calificaciones = ft.Container(
        ft.Column([
            ft.Row([
                ft.Container(content=ft.Text('Calificaciones',color='white',text_align='center',size=20),bgcolor='#0D257C',
                        width=250,height=50,alignment=ft.alignment.center,border_radius=30)
            ],alignment=ft.MainAxisAlignment.CENTER),
            ft.Row([
                ft.DataTable(
                    columns=[
                        ft.DataColumn(ft.Text("Modulo")),
                        ft.DataColumn(ft.Text("     ")),
                        ft.DataColumn(ft.Text("Parcial 1")),
                        ft.DataColumn(ft.Text("Parcial 2")),
                        ft.DataColumn(ft.Text("Final")),
                    ],
                    rows=[
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 1')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 2')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 3')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 4')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 5')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        
                            
                    ],column_spacing=20
                ),
                ft.DataTable(
                    columns=[
                        ft.DataColumn(ft.Text("Modulo")),
                        ft.DataColumn(ft.Text("     ")),
                        ft.DataColumn(ft.Text("Parcial 1")),
                        ft.DataColumn(ft.Text("Parcial 2")),
                        ft.DataColumn(ft.Text("Final")),
                    ],
                    rows=[
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 6')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 7')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 8')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 9')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                        ft.DataRow(cells=[
                            ft.DataCell(ft.Text('Modulo 10')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                            ft.DataCell(ft.Text('')),
                        ]),
                    ],column_spacing=20)
                ,
            ],alignment=ft.MainAxisAlignment.CENTER),
            ft.Row([
                ft.Text('Calificacion Final: ')
            ],alignment=ft.MainAxisAlignment.CENTER)
        ])

    )

    page.add(barra,bar,menu)
    personal.visible = False
    horario.visible = False
    calificaciones.visible = False
    page.add(personal,horario,calificaciones)

    page.on_resize = text_sizing
    
ft.app(target=main,view=ft.AppView.WEB_BROWSER)