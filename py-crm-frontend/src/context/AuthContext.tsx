import { createContext, useContext, useEffect, useMemo, useState } from 'react'

type AuthContextType = {
  token: string | null
  login: (token: string) => void
  logout: () => void
}

const AuthContext = createContext<AuthContextType | undefined>(undefined)

const TOKEN_KEY = 'crm_access_token'

export const AuthProvider = ({ children }: { children: React.ReactNode }) => {
  const [token, setToken] = useState<string | null>(null)

  useEffect(() => {
    const stored = localStorage.getItem(TOKEN_KEY)
    if (stored) setToken(stored)
  }, [])

  const value = useMemo(
    () => ({
      token,
      login: (t: string) => {
        localStorage.setItem(TOKEN_KEY, t)
        setToken(t)
      },
      logout: () => {
        localStorage.removeItem(TOKEN_KEY)
        setToken(null)
      },
    }),
    [token],
  )

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>
}

export const useAuth = () => {
  const ctx = useContext(AuthContext)
  if (!ctx) throw new Error('useAuth must be used within AuthProvider')
  return ctx
}
