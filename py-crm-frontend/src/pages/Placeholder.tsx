import './Placeholder.css'

export const Placeholder = ({ title, description }: { title: string; description?: string }) => {
  return (
    <div className="placeholder">
      <h1>{title}</h1>
      <p>{description ?? 'Coming soon'}</p>
      <div className="grid">
        <div className="skeleton" />
        <div className="skeleton" />
        <div className="skeleton" />
      </div>
    </div>
  )
}
