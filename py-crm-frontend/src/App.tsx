import { Route, Routes } from 'react-router-dom'
import { AuthProvider } from './context/AuthContext'
import { ProtectedRoute } from './components/ProtectedRoute'
import { AppLayout } from './components/AppLayout'
import { Login } from './pages/Login'
import { Dashboard } from './pages/Dashboard'
import { Jobs } from './pages/Jobs'
import { Integrations } from './pages/Integrations'
import { Mapping } from './pages/Mapping'
import { Users } from './pages/Users'
import { Audit } from './pages/Audit'
import { Settings } from './pages/Settings'
import './App.css'

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route element={<ProtectedRoute />}>
          <Route element={<AppLayout />}>
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/jobs" element={<Jobs />} />
            <Route path="/integrations" element={<Integrations />} />
            <Route path="/mapping" element={<Mapping />} />
            <Route path="/users" element={<Users />} />
            <Route path="/audit" element={<Audit />} />
            <Route path="/settings" element={<Settings />} />
            <Route path="*" element={<Dashboard />} />
          </Route>
        </Route>
        <Route path="*" element={<Login />} />
      </Routes>
    </AuthProvider>
  )
}

export default App
