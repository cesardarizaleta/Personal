import flet as ft

def main(page: ft.Page):

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

    txtControl = ft.TextField(hint_text='Usuario Docente',bgcolor='white',border_radius=10,width=380,height=50)
    txtClave = ft.TextField(hint_text='Clave de acceso',bgcolor='white',border_radius=10,width=380,height=50)

    container = ft.Container(
        ft.Column([
            ft.Container(
                ft.Row([
                    ft.Text('Inicio de Sesion',color='#0D257C',weight=ft.FontWeight.BOLD,size=20,
                            font_family='OpenSans')
                ],alignment=ft.MainAxisAlignment.CENTER)
            ,bgcolor='white',width=450,height=50,border_radius=60,padding=10),
            ft.Row([
                ft.Image('https://i.postimg.cc/rszvbGS4/4.png',border_radius=100)
            ],alignment=ft.MainAxisAlignment.CENTER,height=100,width=page.width*0.3),
            ft.Divider(height=30,color='transparent'),
            ft.Column([
                txtControl,txtClave,
                
            ]),
            ft.Row([
                ft.FilledButton('Aceptar',style=ft.ButtonStyle(bgcolor='#3F844B'))
            ],alignment=ft.MainAxisAlignment.CENTER),
        ])
    ,padding=20,width=page.width*0.3,height=page.width*0.3,bgcolor='#0D257C',
    border_radius=40,margin = ft.margin.only(top=80,left=page.width*0.35))

    

    page.add(barra,container)
    
ft.app(target=main,view=ft.AppView.WEB_BROWSER)