import React from 'react'

const UrlContext = React.createContext()

const urls = {
  questionUrl: 'http://localhost:8096',
}

const UrlConsume = () => React.useContext(UrlContext)

const UrlProvider = ({ children }) => {
  return <UrlContext.Provider value={urls}> {children} </UrlContext.Provider>
}

export { UrlProvider, UrlConsume }
