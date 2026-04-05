import { Link, NavLink, Outlet, useNavigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'
import './AppLayout.css'

const navItems = [
  { to: '/dashboard', label: 'Dashboard' },
  { to: '/jobs', label: 'Jobs' },
  { to: '/integrations', label: 'Integrations' },
  { to: '/mapping', label: 'Data Mapping' },
  { to: '/users', label: 'Users' },
  { to: '/audit', label: 'Audit' },
  { to: '/settings', label: 'Settings' },
]

export const AppLayout = () => {
  const { logout } = useAuth()
  const navigate = useNavigate()
  return (
    <div className="app-shell">
      <aside className="sidebar">
        <Link to="/dashboard" className="brand">
          <span className="dot" />
          <div>
            <strong>Fusion CRM</strong>
            <small>Integration Console</small>
          </div>
        </Link>
        <nav>
          {navItems.map((item) => (
            <NavLink key={item.to} to={item.to} className="nav-item">
              {item.label}
            </NavLink>
          ))}
        </nav>
        <button
          className="logout"
          onClick={() => {
            logout()
            navigate('/login')
          }}
        >
          Logout
        </button>
      </aside>
      <main className="content">
        <header className="topbar">
          <div className="env">Local</div>
          <div className="user-pill">Admin</div>
        </header>
        <div className="page">
          <Outlet />
        </div>
      </main>
    </div>
  )
}
