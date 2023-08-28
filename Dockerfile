ARG vscode
RUN if [[ -z "$devcontainercli" ]] ; then printf "\nERROR: This Dockerfile needs to be built with VS Code !" && exit 1; else printf "VS Code is detected: $devcontainercli"; fi