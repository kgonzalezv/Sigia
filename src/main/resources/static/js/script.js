function cargarDatosModalCategoria(button) {
    const id = button.getAttribute('data-id');
        fetch(`/categorias/editar/${id}`)
            .then(response => response.text())
            .then(html => {
                const parser = new DOMParser();
                const doc = parser.parseFromString(html, 'text/html');
                const modalConect = doc.getElementById('modalContentFormEdit');
                document.querySelector('#editarModal .modal-body').innerHTML = modalConect.innerHTML;
            })
            .catch(error => console.error('Error al cargar los datos:', error));
}

function cargarDatosModalProducto(button) {
    const id = button.getAttribute('data-id');
    fetch(`/productos/editar/${id}`)
        .then(response => response.text())
        .then(html => {
            const parser = new DOMParser();
            const doc = parser.parseFromString(html, 'text/html');
            const modalConect = doc.getElementById('modalContentFormEditProducto');
            console.log(doc, modalConect);
            document.querySelector('#editarModalProducto .modal-body').innerHTML = modalConect.innerHTML;
        })
        .catch(error => console.error('Error al cargar los datos:', error));
}
