const { app, BrowserWindow } = require('electron')

const createWindow = () => {
  const win = new BrowserWindow({
    width: 800,
    height: 600
  })

  win.loadFile('index.html')
}

//Correr el Programa con npm run dev, o como esta en el package.json
app.whenReady().then(() => {
  createWindow()
})