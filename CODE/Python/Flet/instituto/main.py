import flet as ft

def main(page: ft.Page):

    def goEstu(e):
        
        page.go('/estudiante')
        page.update()

    def goDoc(e):
        page.route = '\login-02'
        page.update()

    def goAdmin(e):
        page.route = '\login-03'
        page.update()
    
    page.theme_mode = ft.ThemeMode.LIGHT

    barra = ft.Container(ft.Row([
        ft.Text('Sistema Integrador de calificaciones de lenguas extranjeras (SICLE)'
                ,font_family='Open-Sans',
                weight=ft.FontWeight.BOLD,size=20,
                color='white')
    ],width=page.width,
    height=page.height * 0.1,
    alignment=ft.MainAxisAlignment.CENTER)
    ,bgcolor='#0D257C',margin=-10)

    logo = ft.Row([
        ft.Image('/Users/cesar/Desktop/Programacion/instituto/images/images/4.png'
            ),
        ft.Text('Instituto Tecnologico de Tuxtepec'),
        
    ],alignment=ft.MainAxisAlignment.CENTER,height=page.height*0.15)

    opciones = ft.Container(
        ft.Row([
            ft.Column([
                ft.Image('/Users/cesar/Desktop/Programacion/instituto/images/images/1.png'),
                ft.Text('Estudiantes',weight=ft.FontWeight.W_700,size=30),
                ft.Text('Modulo de Consultas y servicios para los estudiantes',text_align='center'),
                ft.TextButton('Estudiante >',on_click=goEstu)
                
            ],width=page.width*0.2
            ,alignment=ft.MainAxisAlignment.CENTER,
            horizontal_alignment=ft.CrossAxisAlignment.CENTER),
            ft.Column([
                ft.Image('/Users/cesar/Desktop/Programacion/instituto/images/images/2.png'),
                ft.Text('Docente',weight=ft.FontWeight.W_700,size=30),
                ft.Text('Modulo de Consultas y Actividades',text_align='center'),
                ft.TextButton('Docente >',on_click=goDoc)
            ],width=page.width*0.2
            ,alignment=ft.MainAxisAlignment.CENTER,
            horizontal_alignment=ft.CrossAxisAlignment.CENTER),
            ft.Column([
                ft.Image('/Users/cesar/Desktop/Programacion/instituto/images/images/3.png'
                    ),ft.Text('Administrador',weight=ft.FontWeight.W_700,size=30),
                    ft.Text('Modulo de Consultas',text_align='center'),
                    ft.TextButton('Administrador >',on_click=goAdmin)
            ],width=page.width*0.2
            ,alignment=ft.MainAxisAlignment.CENTER,
            horizontal_alignment=ft.CrossAxisAlignment.CENTER
            )
        ],vertical_alignment=ft.MainAxisAlignment.CENTER,
        height=page.height*0.7,spacing=30,alignment=ft.MainAxisAlignment.CENTER)
    )
    
    page.add(barra,logo,opciones)
ft.app(target=main,view=ft.AppView.WEB_BROWSER)