import { Route, Routes } from 'react-router-dom'
import { AuthProvider } from './context/AuthContext'
import { ProtectedRoute } from './components/ProtectedRoute'
import { AppLayout } from './components/AppLayout'
import { Login } from './pages/Login'
import { Dashboard } from './pages/Dashboard'
import { Placeholder } from './pages/Placeholder'
import './App.css'

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route element={<ProtectedRoute />}>
          <Route element={<AppLayout />}>
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/jobs" element={<Placeholder title="Jobs & Schedules" />} />
            <Route path="/integrations" element={<Placeholder title="Integrations" />} />
            <Route path="/mapping" element={<Placeholder title="Data Mapping" />} />
            <Route path="/users" element={<Placeholder title="Users & Roles" />} />
            <Route path="/audit" element={<Placeholder title="Audit Logs" />} />
            <Route path="/settings" element={<Placeholder title="Settings" />} />
            <Route path="*" element={<Dashboard />} />
          </Route>
        </Route>
        <Route path="*" element={<Login />} />
      </Routes>
    </AuthProvider>
  )
}

export default App
