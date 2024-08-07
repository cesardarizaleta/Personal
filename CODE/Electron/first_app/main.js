const { app, BrowserWindow } = require('electron')

const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 600
  })

  win.loadFile('index.html')
}
//Con comando R para recargar la pagina
//Realmente es una pagina web
//Correr el Programa con npm run dev, o como esta en el package.json
app.whenReady().then(() => {
  createWindow()
})